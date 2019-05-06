package questions.common;

public class CommonUtils<T> {
    public void showArrays(T[] arrays) {
        String str = "[";
        for (int i = 0; i < arrays.length; i++) {
            str +=arrays[i] + ",";
        }
        str = str.substring(0, str.length() - 1);
        str += "]";
        System.out.println(str);
    }
}
