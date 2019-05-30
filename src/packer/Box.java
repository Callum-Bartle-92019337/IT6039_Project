package packer;

/**
 *
 * @author I.M.Bad
 */
public class Box {

    private Manifest contents;
    private Customer customer;
    private Depot depot;
    private float capacity;

    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
        capacity = 20;
    }

    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }

    public void addProduct(Product product, int quantity) {
        if (canFit(product, quantity));
        {
            contents.addProduct(product, quantity);
        }
    }

    public String getLabel() {
        StringBuilder label = new StringBuilder();
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");
        }
        return label.toString();
    }

    public String toString() {
        return getLabel();
    }

    public boolean isEmpty() {
        return contents.isEmpty();
    }

    public double getWeight() {
        return contents.getTotalWeight();
    }

    public boolean canFit(Product p) {
        return p.getWeight() <= remainingCapacity();
    }

    public boolean canFit(Product p, int quantity) {
        return (p.getWeight() * quantity) <= remainingCapacity();
    }

    public double remainingCapacity() {
        return capacity - this.getWeight();
    }

    public boolean isFragile() {
        return contents.hasFragileItems();
    }

    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }

    public boolean isHeavy() {
        return this.getWeight() > 15;
    }
}
