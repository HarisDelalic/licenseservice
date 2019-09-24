package com.microservices.licenseservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="licenses")
public class License {

    @Id
    private String id;

    private String productName;
    private String type;
    private String organizationId;

    public License() { }

    public License(LicenseBuilder licenseBuilder) {
        this.id = licenseBuilder.id;
        this.productName = licenseBuilder.productName;
        this.type = licenseBuilder.type;
        this.organizationId = licenseBuilder.organizationId;
    }

    public static class LicenseBuilder {

        private String id;
        private String productName;
        private String type;
        private String organizationId;

        public static LicenseBuilder newInstance()
        {
            return new LicenseBuilder();
        }

        public LicenseBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public LicenseBuilder withProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public LicenseBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public LicenseBuilder withOrganization(String organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        public License build() {
            return new License(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getType() {
        return type;
    }

    public String getOrganizationId() {
        return organizationId;
    }
}
