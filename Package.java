public class Package
{
    private final int id;
    private boolean delivery = false;
    private final Customer sender;
    private final Customer reciever;
    private final Carrier carrier;
    
    public Package(Customer sender, Customer reciever, Carrier carrier)
    {
        this.sender = sender;
        this.reciever = reciever;
        this.carrier = carrier;
        this.id = Package.getRandomID();
    }
    
    public void markDelivery(int carrierCode)
    {
        if(carrierCode == carrier.getCode())
        {
            this.delivery = true;
        }
    }
    
    public boolean isDelivered(){
        return delivery;
    }
    
    public static int getRandomID()
    {
        return (int)((Math.random()*Math.pow(10, 5) * 9)+Math.pow(10, 5));
    }
}
