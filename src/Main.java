public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public static void prefixTable(char[] pattern,int[] prefixTable){
        int i = 1;
        int j = 0;
        prefixTable[0] = 0;
        while(i<pattern.length){
            if (pattern[i]==pattern[j]){
                prefixTable[i] = j + 1;
                i++;
                j++;
            } else if (j>0) {
                j = prefixTable[j-1];
            }else {
                prefixTable[i] = 0;
                i++;
            }
        }
    }
}