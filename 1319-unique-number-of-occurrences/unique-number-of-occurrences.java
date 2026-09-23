class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Arrays.sort(arr);
        // for(int i=0;i<arr.length-1;i++){
        //     if(arr[i]==arr[i+1]){
        //         return true;
        //     }else if(arr[arr.length-1]>0){
        //         return false;
        //     }
        // }
        // return false;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        Set<Integer> uniqueCounts = new HashSet<>();
        for (int freq : countMap.values()) {
            if (!uniqueCounts.add(freq)) {
                return false; // Found a duplicate frequency
            }
        }
        
        return true;

    }
}