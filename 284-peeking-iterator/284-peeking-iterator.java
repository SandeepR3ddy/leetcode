// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer>
{
    private Queue<Integer> ele;
	public PeekingIterator(Iterator<Integer> iterator)
    {
	    ele = new LinkedList<>();
		
		// Adding elements to queue
        convert(iterator);
	}
	
	public Integer peek()
    {
        return this.ele.peek();
	}
	
	@Override
	public Integer next()
    {
	    return this.ele.remove();
	}
	
	@Override
	public boolean hasNext()
    {
	    if(this.ele.size() > 0)
        {
            return true;
        }
        return false;
	}
    
	// Converting Iterator to Queue
    private void convert(Iterator<Integer> iterator)
    {
        while(iterator.hasNext())
        {
            ele.add(iterator.next());
        }
    }
}