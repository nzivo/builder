CREATE TABLE projects (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    status ENUM('ACTIVE', 'COMPLETED', 'ARCHIVED', 'PENDING', 'ON_HOLD', 'CANCELLED') NOT NULL DEFAULT 'ACTIVE',
    owner_id BIGINT,
    manager_id BIGINT,
    location VARCHAR(255),  -- Field for project location
    cost DECIMAL(10, 2),    -- Field for project cost
    feature_image VARCHAR(255),  -- URL for the feature image
    other_images TEXT,       -- Comma-separated links or JSON for other images
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (manager_id) REFERENCES users(id),
    FOREIGN KEY (owner_id) REFERENCES users(id)
);
