//INVERTED HALF PYRAMID
//****
//***
//**
//*
public class pattern4 {
    public static void main(String[] args) {
        int n=4;
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
//OR
//for(int i=n;i>=1;i--){
//    for(int j=1;j<=i;j++){
//        sout("*");
//        }
//        }