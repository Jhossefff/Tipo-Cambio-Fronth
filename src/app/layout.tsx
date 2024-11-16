import './globals.css';
import Sidebar from '../components/Sidebar';

export const metadata = {
  title: 'Sistema de Tipo de Cambio',
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="es">
      <body className="flex bg-gray-100">
        <Sidebar />
        <main className="flex-1 p-6">{children}</main>
      </body>
    </html>
  );
}
