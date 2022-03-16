class animal1{
    private int id;
    private String name;
    private int age;
    public int get(){
        return id;
    }

    public void set(int id){
        this.id=id;
    }
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name=name;
    }
    public int getage(){

        return age;
    }
    public void setage(int age){
        this.age=age;
    }


}

public class animal {
    public static void main(String[] args){
        animal1 n=new animal1();
        n.set(90);
        n.setname("srijoni");
        n.setage(22);
        System.out.println(n.get()+n.getname());
    }
}
