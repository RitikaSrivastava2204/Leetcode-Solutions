class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int productPrefix = 1;
        int productSuffix = 1;
        int last = nums.length-1;
        for(int i=0; i<nums.length; i++){
             if(productPrefix == 0){
                productPrefix = 1;
            }
            if(productSuffix == 0){
                productSuffix = 1;
            }
            productPrefix *= nums[i];
            productSuffix *= nums[last-i];
            maxProduct = Math.max(Math.max(productPrefix, productSuffix),maxProduct);
        }
        return maxProduct;
    }
    public int maxProductBruteForce(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int product = 1;
            for(int j=i; j<nums.length; j++){
                product *= nums[j];
                maxProduct = Math.max(product, maxProduct);
            }
        }
        return maxProduct;
    }

}