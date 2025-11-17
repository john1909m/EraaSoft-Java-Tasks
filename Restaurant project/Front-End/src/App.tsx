import './App.css';
import Category from './components/Category/Category';
import ProductCard from './components/ProductCard/ProductCard';
import { useEffect, useState, useCallback } from 'react';
import { useDispatch, useSelector } from "react-redux";
import { fetchProducts, selectProducts, selectLoading } from './store/ProductSlice';
import type { AppDispatch } from './store/store';
import { useSearchParams } from 'react-router-dom';

function App() {
  const [searchParams, setSearchParams] = useSearchParams();
  const dispatch = useDispatch<AppDispatch>();
  const products = useSelector(selectProducts);
  const loading = useSelector(selectLoading);

  const categoryIdFromUrl = parseInt(searchParams.get('categoryId') || '1', 10);
  const [activeCategory, setActiveCategory] = useState<number>(categoryIdFromUrl);

  const handleCategoryChange = useCallback(
    (categoryId: number) => {
      const params = new URLSearchParams(searchParams);
      params.set("categoryId", categoryId.toString());
      params.delete("q");
      setSearchParams(params);
    },
    [searchParams, setSearchParams]
  );

  useEffect(() => {
    const urlCategoryId = parseInt(searchParams.get("categoryId") || "1", 10);
    const query = searchParams.get("q") || "";
  
    if (!isNaN(urlCategoryId)) {
      setActiveCategory(urlCategoryId);
      dispatch(fetchProducts({ categoryId: urlCategoryId, searchTerm: query }));
    }
  }, [searchParams, dispatch]);

  if (loading) {
    return <p className="text-center">Loading...</p>;
  }

  const productsArray = Array.isArray(products) ? products : [];


  return (
    <>
      <Category 
        activeCategory={activeCategory}
        onCategoryChange={handleCategoryChange}
      />
      <div className='flex justify-center w-full'>
         <div className="grid grid-cols-1 sm:grid-cols-2 gap-5 p-5">
          {productsArray.length > 0 ? (
            productsArray.map((p) => (
              <ProductCard
                key={p.productId}
                image={`/src/assets/${p.productImagePath}`}
                name={p.productName}
                description={p.productDescription}
                price={p.productPrice}
              />
            ))
          ) : (
            <p className="text-center col-span-2">No products found for this category.</p>
          )}
        </div>
      </div>
    </>
  );
}

export default App;
