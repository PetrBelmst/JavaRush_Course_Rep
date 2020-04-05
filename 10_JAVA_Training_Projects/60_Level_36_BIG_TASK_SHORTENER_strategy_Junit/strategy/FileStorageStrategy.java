package com.company.strategy;

public class FileStorageStrategy implements StorageStrategy {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    private int size;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    long maxBucketSize;

    public FileStorageStrategy() {
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            table[i] = new FileBucket();
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public int hash(Long k) {
        long hash = k;
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        return (int) (hash ^ (hash >>> 7) ^ (hash >>> 4));
    }

    public int indexFor(int hash, int length) {
        return hash % (length - 1);
    }

    public Entry getEntry(Long key) {
        int keyHash = hash(key);
        int buckIndex = indexFor(keyHash, table.length);
        if (table[buckIndex] != null) {
            Entry buckEntry = table[buckIndex].getEntry();
            while (buckEntry != null) {
                if (buckEntry.getKey().equals(key)) {
                    return buckEntry;
                }
                buckEntry = buckEntry.next;
            }
        }
        return null;
    }

    public void resize(int newCapacity) {
        FileBucket[] resizedTable = new FileBucket[newCapacity];
        transfer(resizedTable);
        table = resizedTable;
    }

    public void transfer(FileBucket[] newTable) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry buckEntry = table[i].getEntry();
            while (buckEntry != null) {
                Entry nextEntry = buckEntry.next;
                int newBuckIndex = indexFor(buckEntry.hash, newTable.length);
                if (newTable[newBuckIndex] == null) {
                    buckEntry.next = null;
                    newTable[newBuckIndex] = new FileBucket();
                } else {
                    buckEntry.next = newTable[newBuckIndex].getEntry();
                }
                newTable[newBuckIndex].putEntry(buckEntry);
                buckEntry = nextEntry;
            }
            table[i].remove();
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry buckEntry = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, buckEntry));
        size++;
        if (table[bucketIndex].getFileSize() > bucketSizeLimit)
            resize(2 * table.length);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            Entry buckEntry = table[i].getEntry();
            while (buckEntry != null) {
                if (buckEntry.value.equals(value)) {
                    return true;
                }
                buckEntry = buckEntry.next;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int keyHash = hash(key);
        int buckIndex = indexFor(keyHash, table.length);
        if (table[buckIndex] != null) {
            Entry buckEntry = table[buckIndex].getEntry();
            while (buckEntry != null) {
                if (buckEntry.getKey().equals(key)) {
                    buckEntry.value = value;
                    return;
                }
                buckEntry = buckEntry.next;
            }
            addEntry(keyHash, key, value, buckIndex);
        } else {
            createEntry(keyHash, key, value, buckIndex);
        }
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            Entry buckEntry = table[i].getEntry();
            while (buckEntry != null) {
                if (buckEntry.value.equals(value)) {
                    return buckEntry.key;
                }
                buckEntry = buckEntry.next;
            }
        }
        return 0L;
    }

    @Override
    public String getValue(Long key) {
        Entry buckEntry = getEntry(key);
        if (buckEntry != null) {
            return buckEntry.value;
        }
        return null;
    }
}