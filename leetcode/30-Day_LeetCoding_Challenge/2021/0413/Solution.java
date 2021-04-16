/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Iterator<NestedInteger> curIt;
    Stack<Iterator<NestedInteger>> stack;
    Integer next;

    public NestedIterator(List<NestedInteger> nestedList) {
        curIt = nestedList.iterator();
        stack = new Stack();
        next = null;
    }

    @Override
    public Integer next() {
        Integer ans = next;
        next = null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        if (next != null) return true;
        while (!curIt.hasNext() && !stack.isEmpty()) {
            curIt = stack.pop();
        }
        if (curIt.hasNext()) {
            NestedInteger ni = curIt.next();
            while (!ni.isInteger()) {
                if (ni.getList().isEmpty()) {
                    return hasNext();
                }
                stack.push(curIt);
                curIt = ni.getList().iterator();
                ni = curIt.next();
            }
            next = ni.getInteger();
            return true;
        }

        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
