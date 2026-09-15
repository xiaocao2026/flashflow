CREATE DATABASE IF NOT EXISTS flashflow_user
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

CREATE DATABASE IF NOT EXISTS flashflow_product
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

CREATE DATABASE IF NOT EXISTS flashflow_inventory
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

CREATE DATABASE IF NOT EXISTS flashflow_order
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

GRANT ALL PRIVILEGES ON flashflow_user.* TO 'flashflow'@'%';
GRANT ALL PRIVILEGES ON flashflow_product.* TO 'flashflow'@'%';
GRANT ALL PRIVILEGES ON flashflow_inventory.* TO 'flashflow'@'%';
GRANT ALL PRIVILEGES ON flashflow_order.* TO 'flashflow'@'%';
FLUSH PRIVILEGES;
