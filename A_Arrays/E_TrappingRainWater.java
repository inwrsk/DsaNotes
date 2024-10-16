package A_Arrays;
//we calculate the left and right boundaries of the vessel in a loop so that we can estimate how much can be stored init
//this code won't cover the corner cases like less than 2 values
public class E_TrappingRainWater {
    public static int calcWater(int[]arr){
        int res=0;
        //calculate leftboundary
        int[] lb = new int[arr.length];
        lb[0]=arr[0];
        for (int i =1; i<arr.length;i++){
            lb[i] = Math.max(arr[i],lb[i-1]);
        }
        //calculate rightboundary
        int rb[] = new int[arr.length];
        rb[arr.length-1]=arr[arr.length-1];
        for (int i=arr.length-2;i>=0;i--){
            rb[i]=Math.max(arr[i],rb[i+1]);
        }
        //calculating result
        for (int i =0;i<arr.length;i++){
            int water=(Math.min(lb[i],rb[i])-arr[i]);
            res+=water>0?water:0;
        }
        return res;
    }
    public static void main(String args[]){
        int arr[]={4,2,0,6,3,2,5};
        System.out.println(calcWater(arr));
    }
}
