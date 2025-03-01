package A_Arrays;
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water 
// it can trap after raining.
// i.e imagine a city of tall buildings packed together and it rains, how much water can be stored in between all the buildings
//we calculate the left and right boundaries of the vessel in a 2loops respectively so that we can estimate how much can be stored init
// i.e if we are at a building if we know the left and right buildings that are taller than this i.e act like vessel boundaries
// then we can know what can be the water height at that point we stood i.e min(leftboundary,rightboundary)-height of the building
// as the width is 1 no need to multiply with width
// now we calculate for every building like this and eventually add all the water that can be captured
//this code won't cover the corner cases like less than 2 values
//TIP: in imagining the left and right boundaries
// for left boundary:
// imagine you are standing at the left side of the city, its night and you have a torch.
// turn on the torch from that side towards the city
// the buildings you see are the left boundaries i.e the current building is tallest building from that one till the next tallest building you see on the right
// i.e it acts as the left boundary for the buildings from (that current building to the next tallest building on the right)
// similarly for the right boundary
// we note both the left and right boundaries in an array before calculating the water that can be stored
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
