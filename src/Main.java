public class Main {
    public static void main(String[] args) {
        char[] text = {'b', 'a', 'c', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'c', 'a', 'c', 'a'};
        char[] pattern = {'a', 'b', 'a', 'b', 'a', 'c', 'a'};
        int[] prefixTable = new int[pattern.length];
        prefixTable(pattern,prefixTable);
        System.out.println(KMPAlgorithm(text,pattern,prefixTable));
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

    public static int KMPAlgorithm (char[] text,char[] pattern,int[] prefixTable){
        int i=0,j=0;
        while (i<text.length){
            if (text[i]==pattern[j]){
                if (j == (pattern.length-1)){
                    return i-j;
                }
                i++;
                j++;
            }else if (j>0){
                j = prefixTable[j-1];
            }else {
                i++;
            }
        }
        return -1;
    }
}