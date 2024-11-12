package com.example.project;

public class QueueStackTester {
    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq)
    {
    	int check = 1;
    	for(int i = 0; i < q.length(); i++) {
    		T e = q.serve();
    		
    		if(check % 2 == 1) {
    			oq.enqueue(e);
    		}
    		else
    		{
    			eq.enqueue(e);
    		}
    		
			q.enqueue(e);

    		check++;
    		
    	}
    }
    
    public static <T> void remove(LinkedPQ<T> pq, int p)
    {
    	LinkedPQ<T> tmp = new LinkedPQ<>();
    	int length = pq.length();
		    	
    	PQElement<T> e;
		for(int i = 0; i < length; i++) {
			e = pq.serve();
			tmp.enqueue(e.data, e.p);
		}
		
    	for(int i = 0; i < length; i++) {
    		e = tmp.serve();
    		if(e.p >= p) 
    			pq.enqueue(e.data, e.p);
    	}
    	
    }
    public static <T> boolean search(Stack<T> st, T e){
    	boolean found = false;
    	
    	if(st.empty())
    		return false;
    	
    	T el = st.pop();
    	
    	if(el.equals(e))
    		found = true;
    	else{
    		found = search(st, e);
    	}
    	
    	st.push(el);
    		
    	return found;
    }
}
