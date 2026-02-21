package com.bim.in.pojo;

public class BookPojo {
        private String ISBN;

        private String Title;
           private String Description;

    private String Edition;
    public BookPojo()
    {
    }
    public BookPojo(String ISBN, String title, String description, String edition) {
        this.ISBN = ISBN;
        Title = title;
        Description = description;
        Edition = edition;
    }
    public String getISBN() {
            return ISBN;
        }

        public void setISBN(String iSBN) {
            ISBN = iSBN;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            this.Title = title;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            this.Description = description;
        }

        public String getEdition() {
            return Edition;
        }

        public void setEdition(String edition) {
            this.Edition = edition;
        }
        }

