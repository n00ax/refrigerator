CREATE TABLE IF NOT EXISTS refrigerators (
    refrigerator_name text,
    owner_name text,
    PRIMARY KEY (refrigerator_name, owner_name)
);
CREATE TABLE IF NOT EXISTS items(
    item_name text,
    description text,
    expiry timestamp,
    built_in_category text,
    category text,
    item_count int,
    owner_name text,
    refrigerator_name text,
    PRIMARY KEY (item_name, description, expiry, built_in_category, category, refrigerator_name, owner_name)
);