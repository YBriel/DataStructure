package unionFind;
//yuzq  2018/12/25
public interface UF {
    int getSize();
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
}
