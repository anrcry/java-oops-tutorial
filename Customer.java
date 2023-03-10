/**
 * 
 * @author Sayon Roy
 * @version 1.0
 */
public class Customer extends User
{
    private final Package [] sent;
    private int sentIndex;
    private final Package [] rcv;
    private int rcvIndex;
    public Customer(String name, String email, String phone) 
    {
        super(name, email, phone);
        this.sentIndex = -1;
        this.rcvIndex = -1;
        this.sent = new Package[100];
        this.rcv = new Package[100];
    }
    
    public Package getPackageFromIndex(int index, boolean isRcv) 
    {
        int currentIndex = isRcv == true ? this.rcvIndex : this.sentIndex;
        Package pkg [] = isRcv == true ? this.rcv : this.sent;
        if(currentIndex == -1 || currentIndex > index)
        {
            return null;
        }
        return pkg[index];
    }
    
    public Package sendPackage(Customer receiver, Carrier carrier) 
    {
        final Package p = new Package(this, receiver, carrier);
        this.addPackage(p, this.sent, ++this.sentIndex);
        receiver.addPackage(p, receiver.rcv, ++receiver.rcvIndex);
        carrier.addPackage(p);
        return p;
    }    
}
