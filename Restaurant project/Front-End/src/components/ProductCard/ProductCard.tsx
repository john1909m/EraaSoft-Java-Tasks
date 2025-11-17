import React from "react";

interface ProductCardProps {
  image: string;
  name: string;
  description: string;
  price: number;
  onAddToCart?: () => void;
}

const ProductCard: React.FC<ProductCardProps> = ({
  image,
  name,
  description,
  price,
  onAddToCart,
}) => {
  return (
    <div className="flex items-center gap-5 bg-white p-4 rounded-xl shadow-sm border border-gray-200 w-full max-w-xl">
      {/* Product Image */}
      <img
        src={image}
        alt={name}
        className="w-28 h-28 rounded-lg object-cover"
      />

      <div className="flex flex-col w-full">
        {/* Title + Price */}
        <div className="flex justify-between items-start">
          <h2 className="text-xl font-semibold text-gray-900">{name}</h2>
          <span className="text-lg font-semibold text-yellow-500">${price}</span>
        </div>

        {/* Description */}
        <p className="text-gray-500 text-sm mt-1">{description}</p>

        {/* Add To Cart Button */}
        <button
          onClick={onAddToCart}
          className="mt-4 bg-red-600 text-white font-semibold py-2 rounded-lg hover:bg-red-700 transition"
        >
          ADD TO CART
        </button>
      </div>
    </div>
  );
};

export default ProductCard;
