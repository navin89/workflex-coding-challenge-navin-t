import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTable, MatTableDataSource, MatTableModule} from '@angular/material/table';
import {WorkationService} from '../core/workationApi.service';
import {CommonModule, NgClass} from '@angular/common';
import {MatSort, MatSortModule} from '@angular/material/sort';
import {MatIconModule} from '@angular/material/icon';

@Component({
  selector: 'app-workation-table',
  imports: [
    NgClass,
    MatTable,
    CommonModule,
    MatTableModule,
    MatSortModule,
    MatIconModule
  ],
  templateUrl: './workation-table.component.html',
  styleUrl: './workation-table.component.css'
})
export class WorkationTableComponent implements OnInit {

  displayedColumns: string[] = ['employee', 'origin', 'destination', 'start', 'end', 'workingDays', 'risk'];
  dataSource = new MatTableDataSource<any>();
  @ViewChild(MatSort, { static: false }) sort!: MatSort;
  hoveredRow: any = null;

  constructor(private workationService: WorkationService) {}

  ngOnInit() {
    this.loadData();
  }

  loadData(sortBy: string = 'workationId', direction: string = 'asc') {
    this.workationService.getWorkations(sortBy, direction).subscribe(data => {
      this.dataSource.data = data;
      this.dataSource.sort = this.sort;
    });
  }

  // Map country/city to flag emoji
  getFlag(location: string): string {
    const country = this.getCountry(location);
    const map: { [key: string]: string } = {
      Germany: '🇩🇪',
      Spain: '🇪🇸',
      Greece: '🇬🇷',
      India: '🇮🇳',
      Ukraine: '🇺🇦',
      'United States': '🇺🇸',
      Belgium: '🇧🇪'
    };
    return map[country] || '🏳️';
  }

  // Extract just country name
  getCountry(location: string | undefined | null): string {
    if (!location) return '';
    return location.includes(',') ? location.split(',').pop()!.trim() : location.trim();
  }

  getRiskSvg(risk: string): string {
    const normalized = risk?.trim().toUpperCase();
    if (normalized === 'NO') return 'assets/green-risk.svg';
    if (normalized === 'LOW') return 'assets/yellow-risk.svg';
    if (normalized === 'HIGH') return 'assets/red-risk.svg';
    return 'assets/yellow-risk.svg'; // fallback
  }

  getRiskLabel(risk: string): string {
    const normalized = risk?.trim().toUpperCase();
    if (normalized === 'HIGH') return 'High risk';
    if (normalized === 'LOW' || normalized === 'NO') return 'No risk';
    return '';
  }

  getRiskClass(risk: string): string {
    const normalized = risk?.trim().toUpperCase();
    if (normalized === 'NO') return 'risk-green';
    if (normalized === 'LOW') return 'risk-yellow';
    if (normalized === 'HIGH') return 'risk-red';
    return '';
  }

// For row striping
  isStriped(row: any): boolean {
    return this.dataSource.data.indexOf(row) % 2 !== 0;
  }

}
