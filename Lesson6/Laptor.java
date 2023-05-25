
public class Laptop {

    private  String brand;
    private int ram;
    private int hdd;
    private String os;
    private String colors;




    public Laptop(String brand, int  ram, int hdd , String os, String colors){
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.colors = colors;
    }
/*
    public void setRandomParameters(){

        List<Integer> ram = new ArrayList<>(Arrays.asList(2,4,6,8,10,12,14,16,32));
        List<Integer> hdd = new ArrayList<>(Arrays.asList(256,512,1024,2048));
        List<String> os = new ArrayList<>(Arrays.asList("Windows", "Linux" , "Нет"));
        List<String> colours = new ArrayList<>(Arrays.asList("Серый", "Серебристый" , "Черный", "Красный","Белый"));
        Random random = new Random();
        this.ram = ram.get(random.nextInt(ram.size()));
        this.hdd = hdd.get(random.nextInt(hdd.size()));
        this.colour = os.get(random.nextInt(os.size()));
        this.os = colours.get(random.nextInt(colours.size()));

    }
*/

    public void printDescription (){
        System.out.println(brand);
        System.out.println("Оперативная память: " + ram + " Гб");
        System.out.println("Жесткий диск: " + hdd + " Гб");
        System.out.println("Операционная система: " + os);
        System.out.println("Цвет: " + colors);
    }

/*    public String getBrand(){return brand; }
    public int getRam(){
        return ram;
    }
    public int getHdd(){
        return hdd;
    }
    public String getOs(){
        return os;
    }
    public String getColour(){
        return colors;
    }
    public  void setBrand(String brand){ this.brand = brand;}
    public void setRam(int ram){
        this.ram = ram;
    }
    public void setHdd(int hdd){
        this.hdd = hdd;
    }
    public void setOs(String os){
        this.os = os;
    }
    public void setColour(String colour){
        this.colors = colour;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(!(obj instanceof Laptop)){
            return false;
        }
        int flag = 0;
        Laptop laptop = (Laptop) obj;
        if (brand.equals(laptop.brand) || brand.equals("")){ flag++; }
        if(ram <= laptop.ram || ram == 0){ flag ++; }
        if (hdd <= laptop.hdd || hdd == 0) { flag++; }
        if (os.equals(laptop.os) || os.equals("")){ flag++; }
        if (colors.equals(laptop.colors) || colors.equals("")){ flag++; }
        if (flag == 5){
            return true;
        }
        return false;
    }
}
