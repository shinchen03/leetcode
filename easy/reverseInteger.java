class Solution {
    public int reverse(int x) {
        int temp = 0;
        if(x < 0){
            temp = -x;
        }
        else{
            temp = x;
        }
        if( temp == 0 ){
            return temp;
        }
        int res = 0;
        int result = 0;
        while(temp != 0){
            if( result>(Integer.MAX_VALUE-temp%10)/10 )
                return 0;
            res = temp % 10;
            result = result*10 + res;
            temp /= 10;
        }
        if(x < 0){
            result = - result; 
        }
        return result;
    }
}