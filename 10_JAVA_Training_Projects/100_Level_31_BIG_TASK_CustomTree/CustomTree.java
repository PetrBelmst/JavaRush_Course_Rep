package com.company;

import java.io.Serializable;
import java.util.*;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    private int size;

    public CustomTree() {
        root = new Entry<String>("0");
        root.parent = null;
        root.leftChild = null;
        root.rightChild = null;
        size = 0;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;


        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        boolean mod = false;
        String s = (String) o;
        Entry<String> parent = getParentEntry(s);
        ArrayDeque<Entry<String>> queueA = new ArrayDeque<>();
        ArrayDeque<Entry<String>> queueB = new ArrayDeque<>();
        int count = 0;
        if (parent.rightChild != null && parent.rightChild.elementName.equalsIgnoreCase(s)) {
            queueA.add(parent.rightChild);
            queueB.add(parent.rightChild);
        }
        if (parent.leftChild != null && parent.leftChild.elementName.equalsIgnoreCase(s)) {
            queueA.add(parent.leftChild);
            queueB.add(parent.leftChild);
        }
        Entry<String> node;
        while (!queueA.isEmpty()) {
            node = queueA.poll();
            if (node.leftChild != null) {
                queueA.add(node.leftChild);
                queueB.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queueA.add(node.rightChild);
                queueB.add(node.rightChild);
            }
        }
        count = queueB.size();
        while (!queueB.isEmpty()) {
            node = queueB.pollLast();
            if (node != null) {
                node.parent = null;
                node.leftChild = null;
                node.rightChild = null;
            }
        }
        if (parent.rightChild != null && parent.rightChild.elementName.equalsIgnoreCase(s)) {
            parent.rightChild = null;
            mod = true;
        }
        if (parent.leftChild != null && parent.leftChild.elementName.equalsIgnoreCase(s)) {
            parent.leftChild = null;
            mod = true;
        }
        size -= count;
        return mod;
    }

    public Entry<String> getParentEntry(String s) {
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        Entry<String> neededNode;
        Entry<String> parentNode = null;
        while (!queue.isEmpty()) {
            neededNode = queue.poll();
            if (neededNode.elementName.equalsIgnoreCase(s)) {
                parentNode = neededNode.parent;
                break;
            } else {
                if (neededNode.leftChild != null) {
                    queue.add(neededNode.leftChild);
                }
                if (neededNode.rightChild != null) {
                    queue.add(neededNode.rightChild);
                }
            }
        }
        return parentNode;
    }


    @Override
    public boolean add(String s) {
        boolean result = false;
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        Entry<String> nodeToBeAdded;
        while (!queue.isEmpty()) {
            nodeToBeAdded = queue.poll();
            if (nodeToBeAdded.leftChild == null) {
                nodeToBeAdded.availableToAddLeftChildren = true;
            }
            if (nodeToBeAdded.rightChild == null) {
                nodeToBeAdded.availableToAddRightChildren = true;
            }
            if (nodeToBeAdded.isAvailableToAddChildren()) {
                if (nodeToBeAdded.parent == null) {
                    nodeToBeAdded.parent = nodeToBeAdded;
                }
                if (nodeToBeAdded.availableToAddLeftChildren) {
                    nodeToBeAdded.leftChild = new Entry<>(s);
                    nodeToBeAdded.leftChild.parent = nodeToBeAdded;
                    nodeToBeAdded.availableToAddLeftChildren = false;
                    result = true;
                    break;
                }
                if (nodeToBeAdded.availableToAddRightChildren) {
                    nodeToBeAdded.rightChild = new Entry<>(s);
                    nodeToBeAdded.rightChild.parent = nodeToBeAdded;
                    nodeToBeAdded.availableToAddRightChildren = false;
                    result = true;
                    break;
                }
            } else {
                queue.add(nodeToBeAdded.leftChild);
                queue.add(nodeToBeAdded.rightChild);
            }
        }
        size++;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    public String getParent(String s) {
        Queue<Entry<String>> queue = new ArrayDeque<>();
        queue.add(root);
        Entry<String> neededNode;
        Entry<String> parentNode = null;
        while (!queue.isEmpty()) {
            neededNode = queue.poll();
            if (neededNode.elementName.equalsIgnoreCase(s)) {
                parentNode = neededNode.parent;
                break;
            } else {
                if (neededNode.leftChild != null) {
                    queue.add(neededNode.leftChild);
                }
                if (neededNode.rightChild != null) {
                    queue.add(neededNode.rightChild);
                }
            }
        }
        return parentNode != null ? parentNode.elementName : null;
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}