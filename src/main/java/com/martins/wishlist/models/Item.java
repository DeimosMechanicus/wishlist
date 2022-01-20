package com.martins.wishlist.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("items")
public class Item {

        @Id
        private String id;

        private String name;
        private boolean achived;
        private String alphabet;
        
        public Item() {
        }
        
        public Item(String id, String name, boolean achived, String alphabet) {
            super();
            this.id = id;
            this.name = name;
            this.achived = achived;
            this.alphabet = alphabet;
        }
        
        public Item(String name, boolean achived, String alphabet) {
            super();
            this.name = name;
            this.achived = achived;
            this.alphabet = alphabet;
        }

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

		public boolean isAchived() {
			return achived;
		}

		public void setAchived(boolean achived) {
			this.achived = achived;
		}

		public String getAlphabet() {
			return alphabet;
		}

		public void setAlphabet(String alphabet) {
			this.alphabet = alphabet;
		}

        
}