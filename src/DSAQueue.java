
public class DSAQueue {

	private int count = 0;
	private int MAX_SIZE = 100;
	private Object[] queue;

	public DSAQueue()
	{
		this.queue = new Object[MAX_SIZE];
		this.setCount(0);
	}

	public DSAQueue(int inSize)
	{
		this.setMaxSize(inSize);
		this.queue = new Object[MAX_SIZE];
	}

	public boolean isEmpty()
	{
		return this.count == 0;
	}

	public boolean isFull()
	{
		return this.count == this.MAX_SIZE;
	}

	public void enqueue(Object inItem)
	{
		if(isFull())
		{
			throw new IllegalArgumentException("Queue is full");
		}
		else
		{
			this.queue[this.count] = inItem;
			this.setCount(this.count + 1);
		}
	}

	public Object dequeue()
	{
		Object item = this.peek();

		for(int i = 0; i < this.count - 1; i++)
		{
			this.queue[i] = this.queue[i+1];
		}

		this.setCount(this.count - 1);
		return item;
	}

	public Object peek()
	{
		if(isEmpty())
		{
			throw new IllegalArgumentException("Queue is empty");
		}
		else
		{
			return this.queue[0];
		}
	}

	private void setCount(int inCount)
	{
		if(inCount < 0 || inCount > this.MAX_SIZE)
		{
			throw new IllegalArgumentException("Count must be greater than 0");
		}
		else
		{
			this.count = inCount;
		}
	}

	private void setMaxSize(int inSize)
	{
		if(inSize <= 0)
		{
			throw new IllegalArgumentException("Size must be atleast 1 or more");
		}
		else
		{
			this.MAX_SIZE = inSize;
		}
	}
}
