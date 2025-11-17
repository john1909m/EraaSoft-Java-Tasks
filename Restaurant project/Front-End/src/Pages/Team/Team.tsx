import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import ChefCard from "../../components/ChefCard/ChefCard";
import { fetchChefs, selectChefs, selectChefsLoading } from "../../store/ChefSlice";
import type { AppDispatch } from "../../store/store";

const Team = () => {
  const dispatch = useDispatch<AppDispatch>();
  const chefs = useSelector(selectChefs);
  const loading = useSelector(selectChefsLoading);

  useEffect(() => {
    dispatch(fetchChefs());
  }, [dispatch]);

  return (
    <section className="bg-slate-50">
      <div className="mx-auto max-w-6xl px-4 py-16 sm:px-6 lg:px-8">
        <div className="mb-12 text-center">
          <p className="text-sm font-semibold uppercase tracking-[0.3em] text-amber-600">
            Our Brigade
          </p>
          <h1 className="mt-3 text-4xl font-extrabold text-gray-900 sm:text-5xl">
            Meet the Culinary Virtuosos
          </h1>
          <p className="mx-auto mt-4 max-w-2xl text-base text-gray-600">
            From live-fire artistry to modern pâtisserie, our chefs obsess over flavor, craft, and hospitality. Peek into the brigade powering every service.
          </p>
        </div>

        {loading ? (
          <p className="text-center text-gray-500">Loading chefs...</p>
        ) : chefs.length > 0 ? (
          <div className="grid gap-8 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
            {chefs.map((chef) => (
              <ChefCard
                key={chef.chefId}
                chefName={chef.chefName}
                chefSpec={chef.chefSpec}
                logoPath={`/src/assets/chefs/${chef.logoPath}`}
                facebookLink={chef.facebookLink}
                instagramLink={chef.instagramLink}
                twitterLink={chef.twitterLink}
              />
            ))}
          </div>
        ) : (
          <p className="text-center text-gray-500">No chefs available right now.</p>
        )}

        <div className="mt-16 rounded-3xl bg-white/70 p-10 text-center shadow-inner backdrop-blur">
          <h2 className="text-2xl font-semibold text-gray-900">Book the Chef’s Table</h2>
          <p className="mt-3 text-gray-600">
            Private tastings, collaborations, or chef’s table experiences—let us curate an unforgettable service.
          </p>
          <button className="mt-6 rounded-full bg-amber-600 px-6 py-3 text-sm font-semibold uppercase tracking-wide text-white shadow-lg shadow-amber-600/30 transition hover:bg-amber-500">
            Plan an Experience
          </button>
        </div>
      </div>
    </section>
  );
};

export default Team;