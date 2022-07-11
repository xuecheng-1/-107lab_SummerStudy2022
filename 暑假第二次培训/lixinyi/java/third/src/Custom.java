public class Custom {
    public Language contact(int areaCode) {
        if(areaCode == 86) {
            return new Chinese();
        }else if(areaCode ==33) {
            return new English();
        }

        return null;
    }
    public static void main(String[] args) {
        Language language = new English();
        language.voice();
        Language language1 = new Chinese();
        language.voice();
        Custom cs =new Custom();
        int areaCode;
        Language language2 = cs.contact (86);
        language.voice();
    }
}
