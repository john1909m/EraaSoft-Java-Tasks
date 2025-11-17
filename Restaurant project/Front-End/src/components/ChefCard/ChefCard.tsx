import { Facebook, Instagram, Twitter } from "lucide-react";

export interface ChefCardProps {
  chefName: string;
  chefSpec: string;
  logoPath: string;
  facebookLink?: string;
  instagramLink?: string;
  twitterLink?: string;
}

const getImageSrc = (logoPath?: string) => {
  if (!logoPath) return "/assets/chefs/default.jpg"; // fallback if needed
  if (logoPath.startsWith("http")) return logoPath;
  if (logoPath.startsWith("/")) return logoPath; // already absolute from public root
  return `/assets/chefs/${logoPath}`; // assume file is in public/assets/chefs
};

const ChefCard = ({
  chefName,
  chefSpec,
  logoPath,
  facebookLink,
  instagramLink,
  twitterLink,
}: ChefCardProps) => {
  return (
    <article className="group relative overflow-hidden rounded-2xl bg-white shadow-lg ring-1 ring-black/5 transition hover:-translate-y-1 hover:shadow-2xl">
      <div className="h-64 overflow-hidden">
        <img
          src={getImageSrc(logoPath)}
          alt={chefName}
          className="h-full w-full object-cover transition duration-500 group-hover:scale-105"
        />
      </div>

      <div className="space-y-3 px-6 py-6">
        <div>
          <h3 className="text-xl font-semibold text-gray-900">{chefName}</h3>
          <p className="text-sm font-medium uppercase tracking-wide text-amber-600">
            {chefSpec}
          </p>
        </div>

        <p className="text-sm text-gray-600 leading-relaxed">
          Crafting signature dishes with seasonal ingredients and bold flavors.
        </p>

        <div className="flex items-center gap-4 text-gray-400">
          {instagramLink && (
            <a
              className="hover:text-amber-600"
              href={instagramLink}
              aria-label={`${chefName} on Instagram`}
              target="_blank"
              rel="noreferrer"
            >
              <Instagram size={20} />
            </a>
          )}
          {facebookLink && (
            <a
              className="hover:text-amber-600"
              href={facebookLink}
              aria-label={`${chefName} on Facebook`}
              target="_blank"
              rel="noreferrer"
            >
              <Facebook size={20} />
            </a>
          )}
          {twitterLink && (
            <a
              className="hover:text-amber-600"
              href={twitterLink}
              aria-label={`${chefName} on Twitter`}
              target="_blank"
              rel="noreferrer"
            >
              <Twitter size={20} />
            </a>
          )}
        </div>
      </div>
    </article>
  );
};

export default ChefCard;