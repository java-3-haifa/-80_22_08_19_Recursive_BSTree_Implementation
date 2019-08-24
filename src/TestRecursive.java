public class TestRecursive {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorialRecursive(5));
        int[] arr = {10,20,30,40,50};
        System.out.println(binarySearch(arr,35));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,35));
        System.out.println(fibonacci(50));
        System.out.println(fibonacciRecursive(50));
    }

    public static int factorial(int n){
        int res = 1;
        for(int i = 1; i <= n; i++){
            res = res * i;
        }
        return res;
    }

    public static int factorialRecursive(int n){
        return (n == 0) ? 1 : n * factorialRecursive(n-1);
    }

    public static int binarySearch(int[] arr, int n){
        int l = 0, r = arr.length - 1, mid;
        while(l <= r){
            mid = (l+r)/2;
            if(arr[mid] == n){
                return mid;
            }else if(n > arr[mid]){
                l = mid+1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int l, int r, int n){
        if(l > r){
            return -1;
        }
        int mid = (l+r) / 2;
        if(arr[mid] == n){
            return mid;
        }
        if(n > arr[mid]){
            l = mid + 1;
        }else{
            r = mid -1;
        }
        return binarySearchRecursive(arr, l, r, n);
    }

    public static long fibonacci(int n){
        if(n <= 1){
            return n;
        }
        int n1 = 0;
        int n2 = 1;
        int res = n1 + n2;
        while(n > 2){
            n1 = n2;
            n2 = res;
            res = n1 + n2;
            n--;
        }
        return res;
    }

    public static long fibonacciRecursive(int n){
        if(n <= 1){
            return n;
        }
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }
}
