-- 1. Accounts (Companies)
CREATE TABLE accounts (
                          id SERIAL PRIMARY KEY,
                          sf_id VARCHAR(18) UNIQUE, -- Simulating SF 18-digit ID
                          name TEXT NOT NULL,
                          industry VARCHAR(100),
                          annual_revenue NUMERIC(15, 2),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Contacts
CREATE TABLE contacts (
                          id SERIAL PRIMARY KEY,
                          first_name TEXT,
                          last_name TEXT NOT NULL,
                          email TEXT UNIQUE,
                          phone VARCHAR(20),
                          account_id INT REFERENCES accounts(id),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. Leads
CREATE TABLE leads (
                       id SERIAL PRIMARY KEY,
                       name TEXT NOT NULL,
                       company TEXT,
                       status VARCHAR(50) DEFAULT 'Open',
                       email TEXT,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 4. Opportunities
CREATE TABLE opportunities (
                               id SERIAL PRIMARY KEY,
                               name TEXT NOT NULL,
                               amount NUMERIC(15, 2),
                               stage_name VARCHAR(50),
                               close_date DATE,
                               account_id INT REFERENCES accounts(id)
);

-- 5. Products
CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          name TEXT NOT NULL,
                          product_code VARCHAR(50),
                          description TEXT,
                          is_active BOOLEAN DEFAULT TRUE
);

-- 6. Pricebooks
CREATE TABLE pricebooks (
                            id SERIAL PRIMARY KEY,
                            name TEXT NOT NULL,
                            is_active BOOLEAN DEFAULT TRUE
);

-- 7. PricebookEntries (Linker between Product and Pricebook)
CREATE TABLE pricebook_entries (
                                   id SERIAL PRIMARY KEY,
                                   pricebook_id INT REFERENCES pricebooks(id),
                                   product_id INT REFERENCES products(id),
                                   unit_price NUMERIC(15, 2)
);

-- 8. Orders
CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        account_id INT REFERENCES accounts(id),
                        effective_date DATE,
                        status VARCHAR(50) DEFAULT 'Draft',
                        total_amount NUMERIC(15, 2)
);

-- 9. OrderItems (Products in an Order)
CREATE TABLE order_items (
                             id SERIAL PRIMARY KEY,
                             order_id INT REFERENCES orders(id),
                             product_id INT REFERENCES products(id),
                             quantity INT DEFAULT 1,
                             unit_price NUMERIC(15, 2)
);

-- 10. Tasks (Activities)
CREATE TABLE tasks (
                       id SERIAL PRIMARY KEY,
                       subject TEXT,
                       activity_date DATE,
                       status VARCHAR(50),
                       priority VARCHAR(50),
                       account_id INT REFERENCES accounts(id)
);

-- SEED DATA
INSERT INTO accounts (name, industry, annual_revenue) VALUES
                                                          ('Acme Corp', 'Manufacturing', 5000000),
                                                          ('Global Tech', 'Technology', 12000000);

INSERT INTO contacts (first_name, last_name, email, account_id) VALUES
                                                                    ('John', 'Doe', 'john@acme.com', 1),
                                                                    ('Jane', 'Smith', 'jane@globaltech.com', 2);

INSERT INTO leads (name, company, status) VALUES
    ('Bob Barker', 'Showbiz Inc', 'New');

INSERT INTO products (name, product_code) VALUES
                                              ('CRM License', 'CRM-001'),
                                              ('Support Plan', 'SUP-101');