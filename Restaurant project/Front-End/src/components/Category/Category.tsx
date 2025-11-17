import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import type { AppDispatch } from '../../store/store';
import { fetchCategories, selectCategories, selectLoading } from '../../store/CategorySlice';
import "bootstrap-icons/font/bootstrap-icons.css";
// import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
// import { faCartArrowDown } from "@fortawesome/free-solid-svg-icons";

interface CategoryFilterProps {
  activeCategory: number;
  onCategoryChange: (categoryId: number) => void;
}

const Category = ({ activeCategory, onCategoryChange }: CategoryFilterProps) => {
  const dispatch = useDispatch<AppDispatch>();
  const categories = useSelector(selectCategories);
  const loading = useSelector(selectLoading);

  useEffect(() => {
    dispatch(fetchCategories());
  }, [dispatch]);

  if (loading) {
    return <p className="text-center">Loading categories...</p>;
  }

  const handleCategoryClick = (categoryId: number) => {
    onCategoryChange(categoryId);
  }

  return (

    <section className="py-8 bg-background">
      <div className="container mx-auto px-4">
        <div className="text-center mb-8">
          <h2 className="text-3xl font-bold text-primary inline-block relative">
            <span className="absolute left-0 right-0 top-1/2 h-px bg-primary/30 -z-10"></span>
            <span className="bg-background px-6 text-amber-600">Food Menu</span>
          </h2>
        </div>

        <div className="flex flex-wrap justify-center gap-3 lg:gap-6">
          {categories.map((category) => {
            const categoryIdNum = Number(category.id);
            const activeCategoryNum = Number(activeCategory);
            const isActive = activeCategoryNum === categoryIdNum;

            return (
              <button
                key={category.id}
                type="button"
                onClick={() => handleCategoryClick(categoryIdNum)}
                className={`relative flex flex-col items-center gap-1 py-6 px-4 hover:bg-amber-100 rounded-lg group transition-colors ${isActive
                    ? "text-amber-500 border-b-2 border-primary"
                    : "text-muted-foreground"
                  }`}
              >
                <div
                  className={`transition-colors scale-140 ${isActive
                      ? "text-primary"
                      : "text-muted-foreground group-hover:text-primary"
                    }`}
                >
                    {/* <i className={"category.categoryLogo"}></i> */}
                    {/* <FontAwesomeIcon icon={category.categoryLogo} /> */}
                </div>

                <div className="flex flex-col items-center">
                  <span className="text-xl">{category.categoryName}</span>
                  <span
                    className={`font-semibold text-base ${isActive
                        ? "text-foreground"
                        : "text-foreground/80"
                      }`}
                  >
                    {category.categoryFlag}
                  </span>
                </div>

                {isActive && (
                  <div className="h-0.5 w-full bg-primary absolute bottom-0 left-0"></div>
                )}
              </button>
            );
          })}
        </div>
      </div>
    </section>
  );
};

export default Category;
