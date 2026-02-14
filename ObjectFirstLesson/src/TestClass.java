public class TestClass extends Object {
    private String name;
    private String category;

    public TestClass(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return getClass().getName() + "(" + "name:" + name + "," + "category:" + category + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TestClass)) return false;

        TestClass p = (TestClass)obj;
        return this.name.equals(p.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 10;
    }
}
