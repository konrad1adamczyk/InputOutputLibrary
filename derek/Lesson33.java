package derek;
import java.io.*;

public class Lesson33{

    public static void main(String[] args){

        Customer[] customers = getCustomers();

        DataOutputStream custOutput = createFile("/Users/Konrad/Documents/workspace3/Java Code/customers2.txt");
        for(Customer person : customers){
            createCustomers(person, custOutput);
        }

        try {
            custOutput.close();
        } catch (IOException e) {

            System.out.println("An I/O Error Occurred");

            System.exit(0);
        }
        getFileInfo();
    }

    private static class Customer{

        public String custName;
        public int custAge;
        public double custDebt;
        public boolean oweMoney;
        public char custSex;

        public Customer(String custName, int custAge, double custDebt, boolean oweMoney, char custSex){

            this.custName = custName; // String
            this.custAge = custAge; // Integer
            this.custDebt = custDebt; // Double
            this.oweMoney = oweMoney; // Boolean
            this.custSex = custSex; // Character
        }
    }
    private static Customer[] getCustomers(){

        Customer[] customers = new Customer[5];

        customers[0] = new Customer("John Smith", 21, 12.25, true, 'M');
        customers[1] = new Customer("Sally Smith", 30, 2.25, true, 'F');
        customers[2] = new Customer("Paul Ryan", 21, 0, false, 'M');
        customers[3] = new Customer("Mark Jacobs", 21, 3.25, true, 'M');
        customers[4] = new Customer("Steve Nash", 21, 5.25, true, 'M');

        return customers;

    }
    private static DataOutputStream createFile(String fileName){

        try{
            File listOfNames = new File(fileName);
            DataOutputStream infoToWrite = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(listOfNames)));
            return infoToWrite;
        }
        catch(IOException e){
            System.out.println("An I/O Error Occurred");
            System.exit(0);
        }
        return null;
    }
    private static void createCustomers(Customer customer, DataOutputStream custOutput){
        try{
            // Write primitive data to the file

            // Writes a String in UTF format
            custOutput.writeUTF(customer.custName);

            // Writes an Integer
            custOutput.writeInt(customer.custAge);

            // Writes a Double
            custOutput.writeDouble(customer.custDebt);

            // Writes a Boolean
            custOutput.writeBoolean(customer.oweMoney);

            // Writes a Character
            custOutput.writeChar(customer.custSex);

            // You also have writeByte, writeFloat, writeLong
            // and writeShort
        }

        catch(IOException e){

            System.out.println("An I/O Error Occurred");
            System.exit(0);
        }
    }
    private static void getFileInfo(){

        System.out.println("Info Written to File\n");
        File listOfNames = new File("/Users/Konrad/Documents/workspace3/Java Code/customers2.txt");
        boolean eof = false;

        try {

            DataInputStream getInfo = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(listOfNames)));

            while (!eof){

                String custName = getInfo.readUTF();
                int custAge = getInfo.readInt();
                double custDebt = getInfo.readDouble();
                boolean oweMoney = getInfo.readBoolean();
                char custSex = getInfo.readChar();

                System.out.println(custName);
                System.out.println(custAge);
                System.out.println(custDebt);
                System.out.println(oweMoney);
                System.out.println(custSex + "\n");
            }
        }
        catch (EOFException e) {
            eof = true;
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't Find the File");
            System.exit(0);
        } catch(IOException e){
            System.out.println("An I/O Error Occurred");
            System.exit(0);
        }
    }
}