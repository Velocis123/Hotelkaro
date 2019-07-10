package com.booking.hotelkaro.Model;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Hotel_list implements Serializable {

       private String restId;
        private String name;
        private String email;
        private String mobileNumber;
        private String restLogoName;
        private String restLogoLink;
        private String restImageName;
        private String restImageLink;
        private String agreementName;
        private String agreementLink;
        private String restinfo;
        private String availablity;
        private String validfor;
        private String notvalid;
        private String applicable;
        private String notapplicable;
        private String alluserRating;
        private String alluserRatingStar;
        private String allrating;
        private String advRes;
        private String status;
        private String showHome;
        private String area;
        private String citiesId;
        private String localityId;
        private String findLocation;
        private String latitude;
        private String longitude;
        private List<Citylist> citylist = null;
        private List<Localitylist> localitylist = null;
        private List<Amenitieslist> amenitieslist = null;
        private List<Gallerylist> gallerylist = null;
        private List<Menulist> menulist = null;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();



        public class Amenitieslist {

            private String amenityId;
            private String restId;
            private String name;
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();

            public String getAmenityId() {
                return amenityId;
            }

            public void setAmenityId(String amenityId) {
                this.amenityId = amenityId;
            }

            public String getRestId() {
                return restId;
            }

            public void setRestId(String restId) {
                this.restId = restId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Map<String, Object> getAdditionalProperties() {
                return this.additionalProperties;
            }

            public void setAdditionalProperty(String name, Object value) {
                this.additionalProperties.put(name, value);
            }

        }



        public class Localitylist {

            private String id;
            private String name;
            private String citiesId;
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCitiesId() {
                return citiesId;
            }

            public void setCitiesId(String citiesId) {
                this.citiesId = citiesId;
            }

            public Map<String, Object> getAdditionalProperties() {
                return this.additionalProperties;
            }

            public void setAdditionalProperty(String name, Object value) {
                this.additionalProperties.put(name, value);
            }

        }




        public class Menulist {

            private String menuId;
            private String restId;
            private String menuName;
            private String menuLink;
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();

            public String getMenuId() {
                return menuId;
            }

            public void setMenuId(String menuId) {
                this.menuId = menuId;
            }

            public String getRestId() {
                return restId;
            }

            public void setRestId(String restId) {
                this.restId = restId;
            }

            public String getMenuName() {
                return menuName;
            }

            public void setMenuName(String menuName) {
                this.menuName = menuName;
            }

            public String getMenuLink() {
                return menuLink;
            }

            public void setMenuLink(String menuLink) {
                this.menuLink = menuLink;
            }

            public Map<String, Object> getAdditionalProperties() {
                return this.additionalProperties;
            }

            public void setAdditionalProperty(String name, Object value) {
                this.additionalProperties.put(name, value);
            }

        }


        public class Citylist {

            private String id;
            private String name;
            private String stateId;
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStateId() {
                return stateId;
            }

            public void setStateId(String stateId) {
                this.stateId = stateId;
            }

            public Map<String, Object> getAdditionalProperties() {
                return this.additionalProperties;
            }

            public void setAdditionalProperty(String name, Object value) {
                this.additionalProperties.put(name, value);
            }

        }


        public class Gallerylist {

            private String galleryId;
            private String restId;
            private String galleryName;
            private String galleryLink;
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();

            public String getGalleryId() {
                return galleryId;
            }

            public void setGalleryId(String galleryId) {
                this.galleryId = galleryId;
            }

            public String getRestId() {
                return restId;
            }

            public void setRestId(String restId) {
                this.restId = restId;
            }

            public String getGalleryName() {
                return galleryName;
            }

            public void setGalleryName(String galleryName) {
                this.galleryName = galleryName;
            }

            public String getGalleryLink() {
                return galleryLink;
            }

            public void setGalleryLink(String galleryLink) {
                this.galleryLink = galleryLink;
            }

            public Map<String, Object> getAdditionalProperties() {
                return this.additionalProperties;
            }

            public void setAdditionalProperty(String name, Object value) {
                this.additionalProperties.put(name, value);
            }

        }



        public String getRestId() {
            return restId;
        }

        public void setRestId(String restId) {
            this.restId = restId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getRestLogoName() {
            return restLogoName;
        }

        public void setRestLogoName(String restLogoName) {
            this.restLogoName = restLogoName;
        }

        public String getRestLogoLink() {
            return restLogoLink;
        }

        public void setRestLogoLink(String restLogoLink) {
            this.restLogoLink = restLogoLink;
        }

        public String getRestImageName() {
            return restImageName;
        }

        public void setRestImageName(String restImageName) {
            this.restImageName = restImageName;
        }

        public String getRestImageLink() {
            return restImageLink;
        }

        public void setRestImageLink(String restImageLink) {
            this.restImageLink = restImageLink;
        }

        public String getAgreementName() {
            return agreementName;
        }

        public void setAgreementName(String agreementName) {
            this.agreementName = agreementName;
        }

        public String getAgreementLink() {
            return agreementLink;
        }

        public void setAgreementLink(String agreementLink) {
            this.agreementLink = agreementLink;
        }

        public String getRestinfo() {
            return restinfo;
        }

        public void setRestinfo(String restinfo) {
            this.restinfo = restinfo;
        }

        public String getAvailablity() {
            return availablity;
        }

        public void setAvailablity(String availablity) {
            this.availablity = availablity;
        }

        public String getValidfor() {
            return validfor;
        }

        public void setValidfor(String validfor) {
            this.validfor = validfor;
        }

        public String getNotvalid() {
            return notvalid;
        }

        public void setNotvalid(String notvalid) {
            this.notvalid = notvalid;
        }

        public String getApplicable() {
            return applicable;
        }

        public void setApplicable(String applicable) {
            this.applicable = applicable;
        }

        public String getNotapplicable() {
            return notapplicable;
        }

        public void setNotapplicable(String notapplicable) {
            this.notapplicable = notapplicable;
        }

        public String getAlluserRating() {
            return alluserRating;
        }

        public void setAlluserRating(String alluserRating) {
            this.alluserRating = alluserRating;
        }

        public String getAlluserRatingStar() {
            return alluserRatingStar;
        }

        public void setAlluserRatingStar(String alluserRatingStar) {
            this.alluserRatingStar = alluserRatingStar;
        }

        public String getAllrating() {
            return allrating;
        }

        public void setAllrating(String allrating) {
            this.allrating = allrating;
        }

        public String getAdvRes() {
            return advRes;
        }

        public void setAdvRes(String advRes) {
            this.advRes = advRes;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getShowHome() {
            return showHome;
        }

        public void setShowHome(String showHome) {
            this.showHome = showHome;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getCitiesId() {
            return citiesId;
        }

        public void setCitiesId(String citiesId) {
            this.citiesId = citiesId;
        }

        public String getLocalityId() {
            return localityId;
        }

        public void setLocalityId(String localityId) {
            this.localityId = localityId;
        }

        public String getFindLocation() {
            return findLocation;
        }

        public void setFindLocation(String findLocation) {
            this.findLocation = findLocation;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public List<Citylist> getCitylist() {
            return citylist;
        }

        public void setCitylist(List<Citylist> citylist) {
            this.citylist = citylist;
        }

        public List<Localitylist> getLocalitylist() {
            return localitylist;
        }

        public void setLocalitylist(List<Localitylist> localitylist) {
            this.localitylist = localitylist;
        }

        public List<Amenitieslist> getAmenitieslist() {
            return amenitieslist;
        }

        public void setAmenitieslist(List<Amenitieslist> amenitieslist) {
            this.amenitieslist = amenitieslist;
        }

        public List<Gallerylist> getGallerylist() {
            return gallerylist;
        }

        public void setGallerylist(List<Gallerylist> gallerylist) {
            this.gallerylist = gallerylist;
        }

        public List<Menulist> getMenulist() {
            return menulist;
        }

        public void setMenulist(List<Menulist> menulist) {
            this.menulist = menulist;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


