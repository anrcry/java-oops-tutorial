public abstract class User 
{
    private final String name, email, phone;
    public User(String name, String email, String phone) 
    {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhone()
    {
        return phone;
    }
    
    public void addPackage(Package p, Package [] arr, int index)
    {
        arr[index] = p;
    }
    
    public static boolean exists(String email, User [] users, User ref_user) {
        for(int i = 0; i < users.length; i++ ) 
        {
            User user = users[i];
            if(user.getEmail().equals(email)) {
                ref_user = user;
                return true;
            }
        }
        ref_user = null;
        return false;
    }
}