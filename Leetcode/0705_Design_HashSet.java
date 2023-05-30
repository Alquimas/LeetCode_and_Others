class MyHashSet {
    boolean[] hash = new boolean[10*10*10*10*10*10 + 1];
    public MyHashSet() {}
    public void add(int key) 
    {
        this.hash[key] = true;
    }
    
    public void remove(int key) 
    {
        this.hash[key] = false;
    }
    
    public boolean contains(int key) 
    {
        return this.hash[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
