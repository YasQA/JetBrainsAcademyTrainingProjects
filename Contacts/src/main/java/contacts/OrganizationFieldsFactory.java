package contacts;

class OrganizationFieldsFactory implements ContactFieldsFactory {
    @Override
    public Name createName() {
        System.out.print("Enter the organizational name: ");
        String name = Main.sc.nextLine();
        Name organizationName = new OrganizationName();
        organizationName.setName(name);
        return organizationName;
    }

    @Override
    public PhoneNumberGeneral createNumber() {
        System.out.print("Enter the number: ");
        String number = Main.sc.nextLine();
        PhoneNumberGeneral phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneNumber(number);
        return phoneNumber;
    }

    public Address createAddress() {
        System.out.print("Enter the address: ");
        String address = Main.sc.nextLine();
        Address orgAddress = new OrganizationalAddress();
        orgAddress.setAddress(address);
        return orgAddress;
    }

    public TimeCreated createTimeCreated() {
        return new TimeCreated();
    }

    public TimeEdited createTimeEdited() {
        return new TimeEdited();
    }

}