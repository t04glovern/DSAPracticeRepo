
public class DSAStack {

	private int count = 0;
	private int MAX_SIZE = 100;
	private Object[] stack;


	public DSAStack()
	{
		this.stack = new Object[MAX_SIZE];
		this.count = 0;
	}

	public DSAStack(int inSize)
	{
		this.stack = new Object[inSize];
		this.setMaxSize(inSize);
		this.count = 0;
	}

	private void setMaxSize(int inSize)
	{
		if(inSize <= 0)
		{
			throw new IllegalArgumentException("Stack must be atleast size 1");
		}
		else
		{
			this.MAX_SIZE = inSize;
		}
	}

	private void setCount(int inCount)
	{
		if(inCount < 0 || inCount > MAX_SIZE)
		{
			throw new IllegalArgumentException("Count is invalid");
		}
		else
		{
			this.count = inCount;
		}
	}

	public boolean isEmpty()
	{
		return this.count == 0;
	}

	public boolean isFull()
	{
		return this.count == MAX_SIZE;
	}

	public void push(Object inItem)
	{
		if(isFull())
		{
			throw new IllegalArgumentException("Stack is full");
		}
		else
		{
			this.stack[count] = inItem;
			this.setCount(this.count + 1);
		}
	}

	public Object pop()
	{
		Object pop = this.top();
		this.setCount(this.count - 1);
		return pop;
	}

	public Object top()
	{
		if(isEmpty())
		{
			throw new IllegalArgumentException("Stack is empty");
		}
		else
		{
			return stack[this.count - 1];
		}
	}
}