package contacts;

class OrganizationalAddress implements Address {
    private String address;

    @Override
    public void setAddress(String address) {
        if (address != null) {
            this.address = address;
        } else {
            this.address = "[no data]";
        }
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return address;
    }
}