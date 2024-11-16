"use client";

import { usePathname, useRouter } from 'next/navigation';

const Sidebar = () => {
  const router = useRouter();
  const pathname = usePathname();

  const menuItems = [
    { name: 'Inicio', path: '/' },
    { name: 'Tipo de Cambio Actual', path: '/actual' },
    { name: 'Historial', path: '/historial' },
  ];

  return (
    <div className="w-64 h-screen bg-gray-900 text-white flex flex-col">
      <div className="flex items-center justify-center h-16 bg-gray-800">
        <h1 className="text-xl font-bold">Mi Proyecto</h1>
      </div>
      <nav className="flex-1">
        <ul className="mt-4 space-y-2">
          {menuItems.map((item) => (
            <li
              key={item.name}
              className={`cursor-pointer p-3 hover:bg-gray-700 ${
                pathname === item.path ? 'bg-gray-700' : ''
              }`}
              onClick={() => router.push(item.path)}
            >
              {item.name}
            </li>
          ))}
        </ul>
      </nav>
      <div className="h-16 bg-gray-800 flex items-center justify-center">
        <p className="text-sm">© 2024 Mi Proyecto</p>
      </div>
    </div>
  );
};

export default Sidebar;
