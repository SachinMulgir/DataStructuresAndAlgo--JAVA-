public class binarySearchFirstAndLastOccurence {
    public static void main(String[] args) {
        int[] arr={5,6,7,7,7,7,7,8,8,8,8,8,9,10,12,16,25,35,45};
        int target=8;
        int first=search(arr,target,true);
        int last=search(arr,target,false);
        System.out.println(first+","+last);
    }
    public static int search(int[] arr,int target, boolean isFirst){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>target)end=mid-1;
            else if(arr[mid]<target)start=mid+1;
            else if(arr[mid]==target){
                if(isFirst){
                    ans=mid;
                    end=mid-1;
                }else{
                    ans=mid;
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}
