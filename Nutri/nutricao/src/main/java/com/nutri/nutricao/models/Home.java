package com.nutri.nutricao.models;

import java.util.List;


public class Home {

    private String title;
    private String subtitle;
    private String description;
    private List<String> contactInfo;
    private List<String> socialMediaLinks;
    private List<ServicePlan> servicePlans;
    private List<Image> imageGallery;

    // Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(List<String> contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<String> getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public void setSocialMediaLinks(List<String> socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
    }

    public List<ServicePlan> getServicePlans() {
        return servicePlans;
    }

    public void setServicePlans(List<ServicePlan> servicePlans) {
        this.servicePlans = servicePlans;
    }

    public List<Image> getImageGallery() {
        return imageGallery;
    }

    public void setImageGallery(List<Image> imageGallery) {
        this.imageGallery = imageGallery;
    }

    public static class ServicePlan {
        private String title;
        private List<String> details;

        // Getters and Setters

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getDetails() {
            return details;
        }

        public void setDetails(List<String> details) {
            this.details = details;
        }
    }

    public static class Image {
        private String src;
        private String alt;

        // Getters and Setters

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }
    }
}