import { ShoppingCart, User } from "lucide-react";
import { useSearchParams } from "react-router-dom";
import { useState } from "react";

interface NavbarProps {
  cartTotal: number;
  cartCount: number;
}

const Navbar = ({ cartTotal, cartCount }: NavbarProps) => {
  const [searchParams, setSearchParams] = useSearchParams();
  const [searchTerm, setSearchTerm] = useState(searchParams.get("searchTerm") || "");

  const handleSearch = (e: React.FormEvent<HTMLFormElement>) => {
    e?.preventDefault();
    const params = new URLSearchParams(searchParams);
    params.delete("categoryId")
    

    if(searchTerm.trim()){
      params.set("q", searchTerm.trim());
    }else{
      params.delete("q");
    }
    
    if(!params.get("categoryId")){
      params.set("categoryId", "1");
    }

    setSearchParams(params);
  }


  return (
    <nav className="bg-nav text-nav-foreground sticky top-0 z-50 shadow-lg bg-gray-900">
      <div className="container mx-auto px-4">
        <div className="flex items-center justify-between h-16">
          {/* Logo */}
          <div className="flex items-center gap-2">
            <div className="text-primary text-3xl">🍽️</div>
            <h1 className="text-2xl text-white font-bold text-primary"><a href="/">Restorant</a></h1>
          </div>

          {/* Search Bar */}
          <form className="hidden md:flex flex-1 max-w-md mx-8" onSubmit={handleSearch}>
          <div className="hidden md:flex flex-1 max-w-md mx-8">
            <div className="relative w-full">
              <input

                type="text"
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                onSubmit={(e: React.FormEvent<HTMLInputElement>) => handleSearch(e)}
                placeholder="Search"
                className="w-full pl-4 pr-10 py-2 bg-background/10 border border-border/20 text-nav-foreground placeholder:text-muted-foreground focus:bg-background/20 rounded-md bg-white"
              />
              <button type="submit" className="absolute right-0 top-0 h-full px-4 text-primary hover:text-primary/80 hover:bg-amber-700 transition-all 0.2s rounded-md text-white bg-amber-600">
                SEARCH
              </button>
            </div>
          </div>
          </form>

          {/* Navigation Links */}
          <div className="hidden lg:flex items-center gap-6">
            <a href="#"><button className="text-nav-foreground hover:text-primary text-white hover:bg-amber-600 transition-all 0.2s p-2 rounded-md hover:cursor-pointer">
              CONTACT
            </button></a>
            <a href="/Team"><button className="text-nav-foreground hover:text-primary text-white hover:bg-amber-600 transition-all 0.2s p-2 rounded-md hover:cursor-pointer">
              TEAM
            </button></a>
            <a href="#"><button className="text-nav-foreground hover:text-primary text-white hover:bg-amber-600 transition-all 0.2s p-2 rounded-md hover:cursor-pointer">
              CATEGORY ▼
            </button></a>
          </div>

          {/* Cart & Profile */}
          <div className="flex items-center gap-4">
            <div className="flex items-center gap-2 text-primary font-semibold text-xl">
              <ShoppingCart className="h-5 w-5 fill-amber-500 stroke-amber-500" />
              {cartCount > 0 && (
                <span className="ml-1 text-sm bg-primary text-primary-foreground rounded-full w-5 h-5 flex items-center justify-center text-white ">
                  {cartCount}
                </span>
              )}
            </div>
            <div className="w-10 h-10 rounded-full bg-muted flex items-center justify-center">
              <User className="h-7 w-7 fill-amber-500" />
            </div>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;