package com.example.sys1.crack_it;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

/**
 * Created by yoshita on 07-03-2018.
 */

public class Temp {
    public static MobileServiceClient mclient;
   public static MobileServiceTable<Question> mToDoTable;
   public static String which;
    //static so that all classes can access it
}
