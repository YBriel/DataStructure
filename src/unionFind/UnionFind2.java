package unionFind;

/**
 * @author: yuzq
 * @Date: 2018-12-25  11:01
 * @Description:
 **/
public class UnionFind2 implements UF {
    private int[] parent;
    public UnionFind2(int size){
        parent =new int[size];
        for(int i=0;i<size;i++){
            parent[i]=i;
        }
    }
    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot){
            return;
        }else {
            parent[pRoot]=qRoot;
        }
    }

    private int find(int p){
        if(p<0 || p>=parent.length){
            throw new IllegalArgumentException("p is oout of bound!");
        }
        while (p!=parent[p]){
            p=parent[p];
        }return p;
    }
}
