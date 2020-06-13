package com.bilal.resources;

public class Transaction
{
    private final String customerID;
    private final int    amount ;

    public Transaction( String CID, int amount )
    {
        this.customerID = CID ;
        this.amount 	 = amount ;
    }

    public String getCID( )    { return customerID; }

    public int    getAmount( ) { return amount ; }

    public String toString( )
    {
        return  new String( "[ " +
                "Customer: " + customerID + ", " +
                "Amount: "   + amount +
                "]"  ) ;
    }
}
