public class Carrier extends User 
{
    private final int code;
    private Package [] pkg;
    private int currentPackage;
    
    public Carrier(String name, String email, String phone)
    {
        super(name, email, phone);
        this.code = (int)((Math.random()*Math.pow(10, 4) * 9)+Math.pow(10, 4));
        this.pkg = new Package[1000];
        this.currentPackage = -1;
    }
    
    public void addPackage(Package p) 
    {
        super.addPackage(p, this.pkg, ++this.currentPackage);
    }
    
    public Package getPackageFromIndex(int index) 
    {
        if(this.currentPackage == -1 || this.currentPackage > index){
            return null;
        }
        return this.pkg[index];
    }
    
    public int getCode()
    {
        return code;
    }
    
    public static boolean exists(String email, int emp, User [] users, User ref_user) {
        for(int i = 0; i < users.length; i++ ) 
        {
            Carrier user = (Carrier) users[i];
            if(user.getEmail().equals(email) && user.getCode() == emp) {
                ref_user = user;
                return true;
            }
        }
        ref_user = null;
        return false;
    }
}