import java.io.*;
public class App 
{
    // Customer customers [] = new Customer[100];
    // Carrier carriers [] = new Carrier[100];
    Customer sender, receiver;
    Carrier carrier;
    Package pkg;
    public App()
    {
            
    }
    
    public void runApp(){
        sender = new Customer("Sayon Roy", "sayon@test.com", "123456");
        receiver = new Customer("Sayon Roy 1", "sayon1@test.com", "1234567");
        carrier = new Carrier("Anweshan", "arc@test.com", "123456");
        
        pkg = sender.sendPackage(receiver, carrier);
        
    }
    
    public static void main(String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        User user = null;
        
        Customer [] customers = new Customer[5];
        int currCustomerLength = -1;
        
        Carrier [] carrier = new Carrier[2];
        
        carrier[0] = new Carrier("Anweshan", "arc@test.com", "123456");
        carrier[1] = new Carrier("Anweshan Test 1", "arc1@test.com", "123456777");
        
        final int USER_AUTH_CHOICE = 700;
        final int CARRIER_AUTH_CHOICE = 800;
        int skip = -1;
        int choice = -1;
        String email = "";
        while(true)
        {
            
             
            
            
                        
            if(skip != -1) {
                choice = skip;
                skip = -1;
            }else {
                System.out.println("1. Register a user\n2. Login a user\n===============\n3. Login a carrier\n0. Exit\n========");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(br.readLine());
            }
            
            if(choice == 0) {
                break;
            }
        
            
            switch(choice)
            {
                case 1:
                    if(currCustomerLength == customers.length) 
                    {
                        System.err.println("No more customers can be onboarded at this moment!");
                        break;
                    }
                    System.out.println("Welcome to customer onboarding!\nYou will be asked to fill up some details."
                    +"\nPlease enter your email:");
                    email = br.readLine();
                    
                    if(currCustomerLength != -1 )
                    {
                        if(User.exists(email, customers, user)) 
                        {
                            System.out.println("Your account already exists with us. Please try to login.");
                            break;
                        }
                    }
                    
                    System.out.println("Enter you name & phone respectively");
                    String name = br.readLine();
                    String phone = br.readLine();
                    customers[++currCustomerLength] = new Customer(name, email, phone);
                    user = customers[currCustomerLength];
                    skip = USER_AUTH_CHOICE;
                    System.out.println("You have been successfully onboarded!");
                    break;
                    
                case 2:
                     System.out.print("Welcome to customer login!\nPlease enter your email address:");
                     email = br.readLine();
                     
                    if(!User.exists(email, customers, user)) 
                    {
                        System.out.println("Your account does not exist. Please try to sign up first.");
                        break;
                    }
                    skip = USER_AUTH_CHOICE;
                    break;
                
                case USER_AUTH_CHOICE:
                    skip = -1;
                    Customer c = (Customer) user;
                    System.out.println("Hello World! I am the post-authentication menu! This is like a submenu. Press 0 to exit");
                    // Write all login menu....
                    break;
                
                case 3:
                    // Please enter email. For confirmation please enter emp code.
                case CARRIER_AUTH_CHOICE:
                    break;
                
                case 0:
                    break;
            }
        }
    }
}